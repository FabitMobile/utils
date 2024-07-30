package ru.fabit.androidutils.image;

import android.graphics.Bitmap;
import android.graphics.Color;

public class Blend {

    private final Mode mode;
    private int[] layer = null;

    public Blend(Bitmap against, Mode mode) {
        this.mode = mode;

        int[] layer = new int[against.getWidth() * against.getHeight()];
        against.getPixels(layer, 0, against.getWidth(), 0, 0,
                against.getWidth(), against.getHeight());
        this.layer = layer;
    }

    private void adjustPixels(int[] pixels) {

        if (layer == null) {
            layer = pixels.clone();
        }

        int[][] cache = new int[256][256];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = apply(i, j, mode);
            }
        }

        int r1, g1, b1;
        int r2, g2, b2;
        for (int i = 0; i < pixels.length; i++) {
            r1 = Color.red(pixels[i]);
            r2 = Color.red(layer[i]);
            g1 = Color.green(pixels[i]);
            g2 = Color.green(layer[i]);
            b1 = Color.blue(pixels[i]);
            b2 = Color.blue(layer[i]);

            r1 = cache[r1][r2];
            g1 = cache[g1][g2];
            b1 = cache[b1][b2];

            pixels[i] = Color.rgb(r1, g1, b1);
        }
    }

    private int apply(int A, int B, Mode mode) {
        return clamp(mode.apply(A, B));
    }

    public void adjustBitmap(Bitmap src) {
        int width = src.getWidth();
        int height = src.getHeight();

        int[] pixels = new int[src.getWidth() * src.getHeight()];
        src.getPixels(pixels, 0, width, 0, 0, width, height);

        adjustPixels(pixels);

        src.setPixels(pixels, 0, width, 0, 0, width, height);

        pixels = null;
    }

    private int clamp(int ch) {
        if (ch > 255)
            return 255;
        if (ch < 0)
            return 0;
        return ch;
    }

    public static abstract class Mode {
        public static final Mode OVERLAY = new Mode() {

            public int apply(int A, int B) {
                return ((B < 128) ? (2 * A * B / 255) : (255 - 2 * (255 - A)
                        * (255 - B) / 255));
            }
        };
        public static final Mode HARD_LIGHT = new Mode() {

            public int apply(int A, int B) {
                return OVERLAY.apply(B, A);
            }
        };
        public static final Mode MULTIPLY = new Mode() {

            public int apply(int A, int B) {
                return (A * B) / 255;
            }
        };

        public abstract int apply(int A, int B);
    }
}
