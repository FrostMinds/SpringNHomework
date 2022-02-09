package skypro.com.springhomework.Courserwork.Constants;

import skypro.com.springhomework.Courserwork.Domain.Question;

public class QuestionConstants {
    public static final Question QUESTION_1 = new Question("Что такое метод?",
            "Метод - это действие, описывающее поведения объектов в определённых условиях.");
    public static final Question QUESTION_2 = new Question("Какие основные свойства строки вы знаете?",
            "Строки строятся из символов в массиве типа char. Строка является неизменяемым объектом.");
    public static final Question QUESTION_3 = new Question("Что такое строка?",
            "Неизменяемый массив символов");
    public static final Question QUESTION_4 = new Question("Что такое цикл?",
            "Цикл - конструктор языка, позволяющий в зависимости от условий многократно использовать один и тот же код.");
    public static final Question QUESTION_5 = new Question("Что такое наследование? Дайте определение и опишите основные особенности данного принципа ООП",
            "Наследование - принцип, по правилам которого новый класс пишется на основе класса-родителя. " +
                    "Для соблюдения принципа наследования в ситуациях с повторяющимся в нескольких классах" +
                    " ,частях кода, нужно объявить родителя и наследовать прочие схожие классы от него.");
}
