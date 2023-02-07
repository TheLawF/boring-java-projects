package danmaku;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class DanmakuWindow {
    public static void main(String[] args) {
        final BufferedImage[] enemy = new BufferedImage[1];
        final BufferedImage[] bullet = new BufferedImage[1];

        final int[] enemy_wid = new int[1];
        final int[] enemy_hei = new int[1];
        final int[] bullet_wid = new int[1];
        final int[] bullet_hei = new int[1];

        Danmaku[] danmakus = new Danmaku[10];
        int width = 1080;
        int height = 640;

        Danmaku dan = new Danmaku(100,
                100,
                1,
                1);

        /*for (int i = 0; i < danmakus.length; i++) {
            danmakus[i] = new Danmaku(((width - enemy_wid[0]) - bullet_wid[0]) / 2,
                    ((height - enemy_hei[0]) - bullet_hei[0]) / 2,
                    1,
                    1);
        }*/

        for (int i = 0; i < danmakus.length; i++) {
            danmakus[i] = new Danmaku(
                    ((width - enemy_wid[0]) - bullet_wid[0]) / 2,
                    0,
                    1,
                    1);
        }

        for (int i = 0; i < danmakus.length; i++) {
            danmakus[i].angle += Math.PI / 32 * (i * 2);
            // 这⬆里⬇ 使用的公式是正弦定理
            if (danmakus[i].angle < Math.PI / 2) {
                danmakus[i].vectorX = danmakus[i].speed *
                        Math.sin(danmakus[i].angle) /
                        Math.sin(Math.PI);
                danmakus[i].vectorY = danmakus[i].speed *
                        Math.sin(Math.PI - danmakus[i].angle) /
                        Math.sin(Math.PI);
            }
        }

        Game.init("弹幕页面一", width,height,
                new GameEngine() {
            @Override
            public void updateLogic() {

            }

            @Override
            public void renderUI(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                try {
                    enemy[0] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                            .getResourceAsStream("center.png")));
                    bullet[0] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                            .getResourceAsStream("bullet.png")));
                    enemy_wid[0] = enemy[0].getWidth();
                    enemy_hei[0] = enemy[0].getHeight();

                    bullet_wid[0] = bullet[0].getWidth();
                    bullet_hei[0] = bullet[0].getHeight();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                /*g2d.drawImage(bullet[0], danmakus[0].x,
                        danmakus[0].y, null);
                danmakus[0].x += 2;
                danmakus[0].y += 7;

                g2d.drawImage(bullet[0], danmakus[1].x,
                        danmakus[1].y, null);
                danmakus[1].x++;
                danmakus[1].y++;*/

                for (Danmaku danmaku : danmakus) {
                    g2d.rotate(danmaku.angle);
                    g2d.drawImage(bullet[0], danmaku.x,
                        danmaku.y, null);
                    danmaku.x += danmaku.vectorX;
                    System.out.println(danmaku.vectorY);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
}
