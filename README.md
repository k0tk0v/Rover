# Задание №2 #

## Реализовать класс, представляющий модель планетохода (ровера). ##

Планетоход ( **Rover** ) движется по плоской поверхности ( **Ground** ), представляющую собой набор клеток. Клетка ( **GroundCell** ) поверхности 
может быть свободной - то есть ровер может по ней проехать - или занятой (по ней проехать нельзя). Для хранения пары координат
используется класс **Point**. Ровер появляется в точке (0, 0) - верхнем левом углу поверхности.

Ровер может совершать следующие операции:

* продвинуться на одну клетку вперед (интерфейс *Moveable*)
* повернуть в любую из 4 сторон (интерфейс *Turnable*)
* взлететь (интерфейс *Liftable*)
* опуститься на любую свободную клетку (интерфейс *Landable*)

Если ровер пытается выйти за пределы поверхности, он должен взлететь.

Ровер понимает, занята или свободна клетка перед ним, с помощью специального устройства - визора ( **GroundVisor** ), 
которое сканирует указанную клетку и сообщает, есть ли на ней препятствие или нет. Если визор пытается заглянуть за край поверхности,
он возбуждает исключение ( **OutOfGroundException** ), которое заставляет ровер взлететь.

## Реализовать программируемый ровер ##

Программируемый ровер ( **ProgrammableRover** ) умеет выполнять все операции, свойственные роверу, однако также умеет 
выполнять программу, записанную в файле (то есть реализует интерфейс *ProgramFileAware*).

Программа представляет собой набор конфигурационных и управляющих инструкций, записанных по одной в строку. Конфигурационная секция
отделяется от секции управления с помощью разделителя "===".

В конфигурационной секции описываются два свойства: log и stats. log отвечает за журналирование команд, выполняемых в ходе работы
программы. stats отвечает за подключение модуля статистики ( **SimpleRoverStatsModule** ), регистрирующего какие клетки были посещены ровером.

В управляющей секции перечисляются команды, аргументы команд перечисляются через пробел (пример в файле *src/test/niit/summer/rover/programmable/program.txt* )

Файл с программой для ровера считывается с помощью парсера ( **RoverCommandParser** ), каждая управляющая инструкция 
порождает объект команды соответствующего типа (интерфейс *RoverCommand* ). Конфигурационные инструкции заполняются в 
карту ( **Map<String, Object>** ) и применяются на этапах чтения файла с программой и/или выполнения программы. В случае возниковения
исключительных ситуаций в процессе чтения (файл не найден, чтение не удалось), возбуждается соответствующее исключение 
( **RoverCommandParserException** ), прерывающее выполнение программы в целом.

## Подсказки ##

* Для выполнения задания потребуется использовать коллекции - ```Collection, List, Map, Set```
* Проверяемые (checked) исключения наследуют ```Exception```, непроверяемые (unchecked) - ```RuntimeException```
* Для построчного чтения из файла используйте ```BufferedReader#readLine()```
* Для создания ```BufferedReader``` используйте ```new BufferedReader(new FileReader([путь до файла]))```
* Получить путь до файла из запущенного приложения можно с помощью ```this.getClass().getResource(path).getFile()```
* После того, как вы закончили читать из файла, не забывайте закрывать его ```BufferedReader#close()```
* Для журналирования используйте метод ```Logger#debug```# Rover
