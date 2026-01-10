# Лабораторная работа №9–10: Продвинутое ООП на Kotlin

# # Описание
Лабораторная работа направлена на освоение продвинутых концепций объектно-ориентированного программирования в языке Kotlin.

# # Структура проекта
Проект включает примеры реализации расширенных механизмов ООП, а также пояснения к основным концепциям.

# # Инструкция по запуску

Клонируйте репозиторий:

bash
git clone <URL_репозитория>
Откройте проект в IntelliJ IDEA.

Запустите любой пример через контекстное меню или напрямую из функции main.

# # Автор
[Шапкин Н.А.]

# # Лицензия
Проект создан в учебных целях.
## 1. Геттеры и сеттеры (Getters & Setters)

В Kotlin свойства по умолчанию имеют автоматически генерируемые геттеры и сеттеры.

### Пример:
```kotlin
class Person {
    var name: String = ""
        get() = field.uppercase()
        set(value) {
            field = value.trim()
        }
    
    var age: Int = 0
        set(value) {
            if (value >= 0) field = value
        }
}
```
fun main() {
    val person = Person()
    person.name = "  Анна  "
    println(person.name) // Выведет: "АННА"
}
## 2. Инкапсуляция (Encapsulation)
Инкапсуляция — это сокрытие внутренней реализации и предоставление контролируемого доступа через публичные методы.

Пример:
kotlin```
class BankAccount {
    private var balance: Double = 0.0

    fun deposit(amount: Double) {
        if (amount > 0) balance += amount
    }

    fun withdraw(amount: Double): Boolean {
        if (amount <= balance) {
            balance -= amount
            return true
        }
        return false
    }

    fun getBalance(): Double = balance
}

fun main() {
    val account = BankAccount()
    account.deposit(1000.0)
    println(account.getBalance()) // 1000.0
}
## 3. Data-классы (Data Classes)
Используются для хранения данных. Автоматически генерируют toString(), equals(), hashCode(), copy().

Пример:
kotlin
data class User(
    val id: Int,
    val name: String,
    val email: String
)

fun main() {
    val user1 = User(1, "Иван", "ivan@mail.com")
    val user2 = user1.copy(email = "ivan.new@mail.com")
    println(user2) // User(id=1, name=Иван, email=ivan.new@mail.com)
}
## 4. Абстрактные классы (Abstract Classes)
Не могут быть созданы напрямую, содержат абстрактные методы (без реализации) и могут содержать реализованные методы.

Пример:
kotlin
abstract class Shape {
    abstract fun area(): Double
    
    fun description() {
        println("Это геометрическая фигура")
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
}

fun main() {
    val circle = Circle(5.0)
    println(circle.area()) // ~78.54
    circle.description() // Это геометрическая фигура
}
## 5. Интерфейсы (Interfaces)
Определяют контракт поведения. Могут содержать:

Функции без реализации

Функции с реализацией по умолчанию (default)

Свойства без состояния (только декларации)

Пример:
kotlin
// Определяем интерфейс видео-плеера:
interface VideoPlayable {
    fun play()
}

// Определяем интерфейс аудио-плеера:
interface AudioPlayable {
    fun play()
}

// Класс реализует оба интерфейса
class MediaPlayer : VideoPlayable, AudioPlayable {
    // Одна реализация для обоих интерфейсов
    override fun play() {
        println("Воспроизводится аудио и видео")
    }
}

// Пример с разными методами в интерфейсах:
interface Clickable {
    fun click()
    fun show() = println("Элемент кликабелен")
}

interface Dragable {
    fun drag()
    fun show() = println("Элемент перемещаем")
}

class Button : Clickable, Dragable {
    override fun click() {
        println("Кнопка нажата")
    }
    
    override fun drag() {
        println("Кнопка перемещена")
    }
    
    // Явное указание, какой метод show использовать при конфликте
    override fun show() {
        super<Clickable>.show()
        super<Dragable>.show()
    }
}

fun main() {
    val player = MediaPlayer()
    player.play() // Воспроизводится аудио и видео

    val button = Button()
    button.click() // Кнопка нажата
    button.drag()  // Кнопка перемещена
    button.show()  // Выведет оба сообщения из интерфейсов
}