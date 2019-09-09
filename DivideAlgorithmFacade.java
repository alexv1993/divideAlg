package com.company;

/**
 * Класс для  реализации алгоритма
 */
public class DivideAlgorithmFacade {
    private int minS; //минимальный размер прямоугольника


    /**
     * Разбиение прямоугольника (рекурсивное или итерационное)
     *
     * @param a    длина
     * @param b    ширина
     * @param n    число делений (20 узлов кластера)
     * @param minS минимальная площадь прямоугольника (на котором заканчивается работа)
     */
    static void method(int a, int b, int n, int minS) {
        //начальная итерация
        //изначально уже есть один прямоугольник - исходный
        int i = 1;
        int r;

        //Создали дерево
        Tree tree = new Tree();

        //Создали узел
        Node node = new Node();

        //задали узел
        tree.setNode(node);
        //установили родителя
        node.setParent(null);
        node.setRect(new Rectangle(new Point(0, 0), a, b));

        Node currentNode = node;

        while (i < n) {
            //флаг для фиксирования, по какой из сторон произошло разбиение
            //флаг необходим для корректного расчета площади
            boolean isA = false;

            // определяем сторону
            if (a > b) {
                r = a;
                isA = true;
            } else {
                r = b;
            }
            //определяем середину

            int c = isA ? (currentNode.getRect().getStart().getX() + r) / 2
                    : (currentNode.getRect().getStart().getY() + r) / 2;

            Point centrPoint = new Point();

            if (isA) {
                centrPoint.setX(c);
                centrPoint.setY(currentNode.getRect().getStart().getY());
            } else {
                centrPoint.setY(c);
                centrPoint.setX(currentNode.getRect().getStart().getX());
            }


            //проверяем, что при делении алгоритм не вышел на границы сторон
            if (c > 0 && c < r) {

                //необходимо знать, по длине или ширине произошло разбиение,

                //Расчет самих площадей
                // isA - работа идет от начала координат


                int s1 = isA ? b * c : a * (b - c);
                int s2 = isA ? b * (a - c) : a * c;

                int maxS;

                Node nodeLeft = new Node();
                Node nodeRight = new Node();

                if (s1 > minS) {
                    Rectangle rectangle = new Rectangle();

                    rectangle.setStart(new Point(currentNode.getRect().getStart().getX(),
                            currentNode.getRect().getStart().getY()));

                    rectangle.setA(c);
                    rectangle.setB(currentNode.getRect().getB());


                    nodeLeft.setParent(currentNode);

                    currentNode.setLeft(nodeLeft);

                } else {
                    s1 = 0;
                }

                if (s2 > minS) {
                    Rectangle rectangle = new Rectangle();

                    rectangle.setStart(new Point(c,
                            currentNode.getRect().getStart().getY()));

                    rectangle.setA(currentNode.getRect().getA() - c);
                    rectangle.setB(currentNode.getRect().getB());


                    nodeRight.setParent(currentNode);

                    currentNode.setLeft(nodeRight);
                } else {
                    s2 = 0;
                }


                if (s1 > s2 && s1 != 0) {
                    maxS = s1;
                    currentNode = nodeLeft;
                } else if (s2 > s1 && s2 !=0) {
                    maxS = s2;
                    currentNode = nodeRight;
                }

                // определяем сторону

            } else {

            }


            i++;
        }


    }

}
