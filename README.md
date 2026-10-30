# BlockWorldRPG

**BlockWorldRPG** - консольная RPG-игра на JAVA, созданная для КТ7 (В дальнейшем для следующих), которая приминяет в себе все 5 паттернов порождающих шаблонов

В моей игре можно создать вашего персонажа, выбрать оружие и броню, настроить характеристики и клонирования мобов

## Используемые технологии

- Java 25 версии
- Maven
- JUnit 5
- IntelliJ IDEA
- Git и GitHub
- GitHub Actions

## Использованные паттерны проектирования

### 1) Singleton

Класс `GameSettings` позволяет существование одного экземпляра настроек игры

Используется для хранения общих параметров игрового процесса

### 2) Factory Method

Реализован через `CharacterFactory` и его подклассы:

- `WarriorFactory` - создание воина
- `MageFactory` - создание мага
- `ArcherFactory` - создание лучника

Помогает создавать персонажей разных классов, не соединяя код к конкретным созданиям

### 3) Abstract Factory

Реализован через `EquipmentFactory`

Создаются две фабрики:

- `FreedomEquipmentFactory` — экипировка Стороны Свободы.
- `VoidEquipmentFactory` — экипировка Бесконечной Бездны

Каждая фабрика создает совместимый набор экипировки: оружие и броню

### 4) Builder

Класс `CharacterBuilder` позволяет пошагово создавать персонажа и настраивать его характеристики

Это делает процесс создания персонажей более легким

### 5. Prototype

Класс `EnemyPrototype` реализует клонирование мобов

Позволяет создавать новые клоны на основе уже существующего моба

## Тестирование

Для проверки кода используется JUnit 5

В проекте создано 20 автоматических тестов:

- `GameSettingsTest`
- `CharacterFactoryTest`
- `EquipmentFactoryTest`
- `CharacterBuilderTest`
- `EnemyPrototypeTest`

Все 20 тестов успешно проходят (Можете удостоверится сами)

## Автоматическая проверка

Я использоал GitHub Actions

Workflow: `.github/workflows/tests.yml`

Статус последней проверки: **Success** (Тоже можете сами посмотреть)

## Запуск проекта

Для запуска проекта необходимы:

- JDK 25
- Maven

### Через IntelliJ IDEA

1) Открыть проект `BlockWorldRPG`.
2) Дождаться загрузки Maven
3) Перейти по `src/main/java/rpg/Main.java`
4) Запустить метод `main()`

### Запуск тестов

В окне Maven открыть раздел `Lifecycle` и запустить команду `test`

## Структура проекта

```text
BlockWorldRPG/
├── .github/
│   └── workflows/
│       └── tests.yml
├── src/
│   ├── main/
│   │   └── java/rpg/
│   │       ├── Main.java
│   │       ├── config/
│   │       ├── character/
│   │       ├── factory/
│   │       ├── equipment/
│   │       ├── builder/
│   │       └── prototype/
│   └── test/
│       └── java/rpg/
├── pom.xml
├── .gitignore
└── README.md

```

**Название проекта:** BlockWorldRPG
