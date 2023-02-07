package StirngFTG;

public class Player {
    public Player(double blood) {
        this.blood = blood;
    }

    double blood;
    double x;
    double y;
    int vertigo = 0;
    float power = 0f;

    public Player(double blood, double x, double y) {
        this.blood = blood;
        this.x = x;
        this.y = y;
    }

    public int laser(double distance, int vertigo){
        int damage = 0;
        if (distance <= 20 && vertigo < 10) {
            damage = 3;
            this.power += 0.05f;
        }
        return damage;
    }

    public int[] fist(double distance, int vertigo){
        int damage = 0;
        if (distance <= 3 && vertigo < 12) {
            damage = 8;
            vertigo += 1;
            this.power += 0.18f;
        }
        return new int[]{damage,vertigo};
    }

    public int[] criticalHit(double distance, int vertigo){
        int damege = 0;
        int fly = 0;
        if (distance > 12 && distance <= 25 && vertigo < 4) {
            damege = 4;
            vertigo += 4;
            fly += 5;
            this.power += 0.08f;
        } else if (distance > 6 && distance <= 12 && vertigo < 4) {
            damege = 12;
            vertigo += 4;
            this.power += 0.1f;
        } else if (distance <= 6 && vertigo < 4) {
            damege = 16;
            vertigo += 4;
            this.power += 0.12f;
        }
        return new int[]{damege,vertigo,fly};
    }

    public int[] comboHit(){
        return new int[]{};
    }

    public int[] kick(double distance, int vertigo){
        int damege = 0;
        int fly = 0;
        if (distance <= 5 && vertigo < 8) {
            damege = 8;
            vertigo += 3;
            fly += 8;
            this.power += 0.1f;
        }
        return new int[]{damege,vertigo,fly};
    }

    public int[] rocketHit(double distance, int vertigo){
        int damage = 0;
        int fly = 0;
        if (distance <= 3 && vertigo < 8) {
            damage = 15;
            vertigo += 5;
            fly += 12;
            this.power += 0.15f;
        }
        else if (distance > 3 && distance <= 8) {
            damage = 7;
            vertigo += 3;
            fly += 12;
            this.power += 0.1f;
        }
        else if (distance > 8 && distance <= 10) {
            damage = 3;
            vertigo += 1;
            fly += 12;
            this.power += 0.05f;
        }
        return new int[]{damage,vertigo,fly};
    }

    public int[] crossWind(double distance,int vertigo){
        int damage = 0;
        int fly = 0;
        if (distance < 15 && vertigo <= 8) {
            damage = 10;
            fly = 20;
            vertigo += 6;
            this.power += 0.08f;
        }
        return new int[]{damage,vertigo,fly};
    }

    public int[] nuclearFusion(double distance,int vertigo){
        int damage = 0;
        int fly = 0;
        if (distance <= 18 && this.power >= 1f) {
            damage = 37;
            vertigo += 20;
        }
        return new int[]{damage,vertigo,fly};
    }

    public Object[] gravity(double distance,int vertigo){
        float damage = 0;
        do {
            if (distance <= 10) {
                distance -= 0.5;
                damage += 0.75f;
            }
            else {
                break;
            }
        }while (distance != 1);
        this.power += .11f;
        return new Object[]{damage,vertigo};
    }

    public Object[] solarStorm(double distance,int vertigo){
        float damage = .0f;
        int fly = 0;
        for (int i = 0; i < 27; i++) {
            if (distance <= 16.3d) {
                damage += .84f;
                vertigo += 1;
                fly += 1;
                this.power += 0.04f;
            }
            else {
                break;
            }
        }
        return new Object[]{damage,vertigo,fly};
    }

    public Object[] tidalLocking(){
        return new Object[]{};
    }

    public void invincible(){

    }

    public int recover(int vertigo){
        return vertigo - 2;
    }
}
