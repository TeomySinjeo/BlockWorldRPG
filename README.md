# BlockWorldRPG

**BlockWorldRPG** - консольная RPG-игра на JAVA, созданная для КТ7 и 8 (В дальнейшем для 9-той), которая применяет в себе все 5 паттернов порождающих шаблонов и 11 поведенческих паттернов проектирования

В моей игре можно создать вашего персонажа, выбрать оружие и броню, настроить характеристики и клонировать мобов. Поведенчиские паттерны работают только в тестах :(

## Используемые технологии

- Java 25 версии
- Maven
- JUnit 5
- IntelliJ IDEA
- Git и GitHub
- GitHub Actions

## Использованные паттерны проектирования

### Порождающие паттерны

### 1) Singleton

Класс `GameSettings` позволяет существование одного экземпляра настроек игры

Используется для хранения общих параметров игрового процесса

### 2) Factory Method

Реализован через `CharacterFactory` и его подклассы:

- `WarriorFactory` - создание воина
- `MageFactory` - создание мага
- `ArcherFactory` - создание лучника

Помогает создавать персонажей разных классов, не соединяя код с конкретными реализациями создания

### 3) Abstract Factory

Реализован через `EquipmentFactory`

Создаются две фабрики:

- `FreedomEquipmentFactory` — экипировка Стороны Свободы
- `VoidEquipmentFactory` — экипировка Бесконечной Бездны

Каждая фабрика создает совместимый набор экипировки: оружие и броню

### 4) Builder

Класс `CharacterBuilder` позволяет пошагово создавать персонажа и настраивать его характеристики

Это делает процесс создания персонажей более легким

### 5. Prototype

Класс `EnemyPrototype` реализует клонирование мобов

Позволяет создавать новые клоны на основе уже существующего моба

---

### Поведенческие паттерны

### 6) Chain of Responsibility

Создан через классы `DamageHandler`, `ArmorHandler`, `ShieldHandler` и `DamageChain`

Позволяет пошагово читать входящий урон, сначала его уменьшает броня, затем щит

### 7) Command

Реализован через:

- `GameCommand` — интерфейс
- `AttackCommand` — атака
- `HealCommand` — лечение
- `DefendCommand` — защита
- `CommandInvoker` — исполнитель

Позволяет представлять игровые действия в виде отдельных объектов и выполнять их сразу с помощью паттерна

### 8) Interpreter

работает через `Expression`, `ComparisonExpression`, `AndExpression` и `ExpressionParser`

Дает разбирать и проверять простые логические выражения, основанные на характеристиках персонажа, например здоровье, силе и броне

### 9) Iterator

Реализован через `GameItem`, `Inventory` и `InventoryIterator`

работает для того чтобы последовательно перебирать предметы инвентаря

### 10) Mediator

Сделан через `BattleMediator`, `BattleParticipant`, `GameBattleMediator` и `BattleSetup`

Позволяет участникам сражения взаимодействовать друг с другом через "Медиатор"

### 11) Memento

Основан на `CharacterMemento`, `CharacterOriginator` и `CharacterHistory`

Дает возможность сохранять состояние персонажа и восстанавливать его в дальнейшем, также реализована возможность отмены последних изменений

### 12) Observer

Инцилизируется через `GameEvent`, `GameObserver`, `GameEventManager` и `BattleLogObserver`

Помогает подписывать игроков на игровые события и автоматически уведомлять их при возникновении этих событий

### 13) State

Собран из `CharacterState`, `CharacterStateContext`, `NormalState`, `StunnedState` и `DeadState`

Изменяет поведение персонажа в зависимости от его текущего состояния: обычного, оглушенного или мертвого

### 14) Strategy

Расположен через `CombatStrategy`, `AggressiveStrategy`, `DefensiveStrategy`, `BalancedStrategy` и `CombatCharacter`

Дает преимущество менять алгоритм ведения боя в зависимости от выбранной стратегии: агрессивной, защитной или сбалансированной

### 15) Template Method

Начат с `GameChallenge`, `DungeonChallenge` и `BossChallenge`

Определяет общий порядок прохождения игрового испытания, позволяя подклассам реализовывать отдельные этапы по своему

### 16) Visitor

Реализован через `CharacterVisitor`, `GameCharacter`, `WarriorUnit`, `MageUnit`, `ArcherUnit`, `CombatPowerVisitor` и `CharacterInfoVisitor`

Позволяет добавлять новые операции над разными типами персонажей без изменения самих классов персонажей

---

## Тестирование

Для проверки кода используется JUnit 5

В проекте предусмотрено **104 автоматических теста** для проверки работы всех реализованных паттернов

Тесты порождающих паттернов:

- `GameSettingsTest`
- `CharacterFactoryTest`
- `EquipmentFactoryTest`
- `CharacterBuilderTest`
- `EnemyPrototypeTest`

Тесты поведенческих паттернов:

- `DamageChainTest`
- `CommandTest`
- `ExpressionParserTest`
- `InventoryIteratorTest`
- `BattleMediatorTest`
- `CharacterMementoTest`
- `GameEventManagerTest`
- `CharacterStateTest`
- `CombatStrategyTest`
- `GameChallengeTest`
- `CharacterVisitorTest`

После полного запуска `mvn test` можно проверить, что все тесты успешно проходят

## Автоматическая проверка

Я использовал GitHub Actions

Workflow: `.github/workflows/tests.yml`

Статус последней проверки: **Success** (Тоже можете сами посмотреть)

## Запуск проекта

Для запуска проекта необходимы:

- JDK 25
- Maven

### Через IntelliJ IDEA

1) Открыть проект `BlockWorldRPG`
2) Дождаться загрузки Maven
3) Перейти по `src/main/java/rpg/Main.java`
4) Запустить метод `main()`

### Запуск тестов

В окне Maven открыть раздел `Lifecycle` и запустить команду `test`

Также тесты можно запустить через терминал командой:

```bash
mvn test
```

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
│   │       ├── prototype/
│   │       └── behavioral/
│   │           ├── chain/
│   │           ├── command/
│   │           ├── interpreter/
│   │           ├── iterator/
│   │           ├── mediator/
│   │           ├── memento/
│   │           ├── observer/
│   │           ├── state/
│   │           ├── strategy/
│   │           ├── templatemethod/
│   │           └── visitor/
│   └── test/
│       └── java/rpg/
│           └── behavioral/
├── pom.xml
├── .gitignore
└── README.md
```

└── README.md

```

**Название проекта:** BlockWorldRPG
