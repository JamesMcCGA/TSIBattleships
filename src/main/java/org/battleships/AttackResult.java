package org.battleships;

public class AttackResult {
    private boolean hit;
    private String message;

    public AttackResult(boolean hit, String message) {
        this.hit = hit;
        this.message = message;
    }

    public boolean isHit() {
        return hit;
    }

    public String getMessage() {
        return message;
    }
}

