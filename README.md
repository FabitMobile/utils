# utils
    
### ClickManager 
Предназначен для ограничения количества нажатий по элементам интерфейса. По умолчанию используется шаг в 500 милисекунд. То есть исполнение кода по нажатию будет происходить не чаще чем один раз в 500 милисекунд.
    
Пример

    private val clickManager = ClickManager()
    clickManager.isApproved { output.openScreen() }

### Collections 
Цель даного синглтона сравнить 2 коллекции между собой при помощи переданного компаратора. Порядок элементов в коллекции игнорируется. Перед сравнением локальная копия каждой коллекции будет отсортирована переданым компаратором. 

Пример

    Collections.areEqualIgnoringOrder(
            reservations1,
            reservations2,
            Comparator { reservation1, reservation2 ->
                if (reservation1.id == reservation2.id) {
                    0
                } else if (reservation1.id < reservation2.id) {
                    -1
                } else {
                    1
                }
            })

### Either 
Класс использует подход из функционального програмирования. Похож на Pair, но в отличии от него у Either может быть либо первое значение либо второе, но ни сразу оба.

### Optional 
Класс обертка. Используем для обертки null в RX цепочках. Имеет метод проверки значения на null.
        
Пример  
  
    val cost = Cost()
    val costOptional = Optional<Cost>(cost)
    if (costOptional.isNotNull) {
        return costOptional.value
    }

### Pair
Класс представляет из себя аналог Pair из sdk kotlin. @Deprecated
    
### Profiler 
Позволяет измерить время выполнения кода.
 
Пример  

    val profiler = Profiler(::println)
    profiler.analysis { output.openScreen() }
    profiler.print()

### ProfilingLog 
Из названия видно что класс поможет с логом событий. Логировать можно по уникаольному ключу с подсчетом затраченого времени на операцию и без. 

Пример

    ProfilingLog.init(true, ::println)
    ProfilingLog.tracking("test", "message")
    ProfilingLog.printAll()

### StringHelper 
Маленький хелпер позволяющий проверить что строка не null, не пустая и содержит не только пробел. Так же находит все вхождения строки2 в строку1 и возврощает список индексов начала и конца вхождений. 

Пример
    val s1 = "00111000011100"
    val s2 = "111"
    val result = StringHelper.getAllOccurrencesOfSubstringStartEndPairs(s1, s2)

Резултат

    2 5
    9 12

### TimeSource 
Интерфейс реализация которого отдает серверное время для использования в критичных местах работы что бы избежать неправильного поведения, например, с переводом часов на устройстве или сменой часового пояса.
