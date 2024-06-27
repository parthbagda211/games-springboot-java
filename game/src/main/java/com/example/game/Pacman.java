package com.example.game;

public class Pacman implements Game {

    @Override
    public void up() {
        System.out.println("Pacman moving up");
    }

    @Override
    public void down() {
        System.out.println("Pacman moving down");
    }

    @Override
    public void left() {
        System.out.println("Pacman moving left");
    }

    @Override
    public void right() {
        System.out.println("Pacman moving right");
    }
}
