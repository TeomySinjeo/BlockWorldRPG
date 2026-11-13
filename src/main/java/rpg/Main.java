
package rpg;

import rpg.generative.character.Character;
import rpg.generative.config.GameSettings;
import rpg.generative.equipment.EquipmentFactory;
import rpg.generative.equipment.FreedomEquipmentFactory;
import rpg.generative.equipment.VoidEquipmentFactory;
import rpg.generative.factory.ArcherFactory;
import rpg.generative.factory.CharacterFactory;
import rpg.generative.factory.MageFactory;
import rpg.generative.factory.WarriorFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Singleton — получаем настройки игры
        GameSettings settings = GameSettings.getInstance();

        System.out.println("BLOCKWORLD");
        System.out.println("Мир: " + settings.getWorldName());
        System.out.println("Сложность мира: " + settings.getDifficulty());

        // Factory Method — выбираем класс персонажа
        System.out.println("\nВыберите класс персонажа:");
        System.out.println("1) Воин");
        System.out.println("2) Маг");
        System.out.println("3) Лучник");
        System.out.print("Ваш выбор: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nПридумайте ваш никнейм: ");
        String name = scanner.nextLine();

        CharacterFactory factory;

        switch (choice) {
            case 1 -> factory = new WarriorFactory();
            case 2 -> factory = new MageFactory();
            case 3 -> factory = new ArcherFactory();
            default -> {
                System.out.println("Следующие классы в разработке...");
                return;
            }
        }

        // Abstract Factory — выбираем фракцию
        System.out.println("\nВыберите фракцию:");
        System.out.println("1) Сторона Свободы");
        System.out.println("2) Бесконечная бездна");
        System.out.print("Ваш выбор: ");

        int factionChoice = scanner.nextInt();

        EquipmentFactory equipmentFactory;

        switch (factionChoice) {
            case 1 -> equipmentFactory = new FreedomEquipmentFactory();
            case 2 -> equipmentFactory = new VoidEquipmentFactory();
            default -> {
                System.out.println("Следующие фракции в разработке...");
                return;
            }
        }

        // Создаем персонажа и выдаём ему экипировку
        Character hero = factory.createCharacter(name);

        hero.setWeapon(equipmentFactory.createWeapon());
        hero.setEquipmentArmor(equipmentFactory.createArmor());

        // Выводим информацию о персонаже
        System.out.println("\nДоюро пожаловать в BLOCKWORLD!");
        hero.showInfo();

        System.out.println("\nГотовы продолжить?");

        scanner.close();
    }
}


