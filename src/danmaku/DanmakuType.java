package danmaku;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class DanmakuType extends JPanel {
    int index = 0;
    public int x;
    public int y;

    public DanmakuType(int x,int y,int index){
        this.index = index;
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (this.index == 1) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            BufferedImage enemy;
            BufferedImage bullet;

            int enemy_wid;
            int enemy_hei;
            int bullet_wid;
            int bullet_hei;

            try {
                enemy = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                        .getResourceAsStream("center.png")));
                bullet = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                        .getResourceAsStream("bullet.png")));
                enemy_wid = enemy.getWidth();
                enemy_hei = enemy.getHeight();

                bullet_wid = bullet.getWidth();
                bullet_hei = bullet.getHeight();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            /*
            danmakus[i] = new Danmaku(
                        ((this.x-enemy_wid)-bullet_wid) / 2 +220 * i,
                        (enemy_hei - bullet_hei) / 2 + 100 * i,
                        1,
                        1);
             */

            Danmaku dan = new Danmaku(((this.x - enemy_wid) - bullet_wid) / 2,
                    ((this.y - enemy_hei) - bullet_hei) / 2,
                    1,
                    1);

            Danmaku[] danmakus = new Danmaku[100];

            if (this.index == 1) {
                for (int i = 0; i < danmakus.length; i++) {
                    danmakus[i] = new Danmaku(
                            ((this.x - enemy_wid) - bullet_wid) / 2 + 31 * i,
                            ((this.y - enemy_hei) - bullet_hei) / 2 + 30 * i,
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
                        System.out.println(Math.toDegrees(danmakus[i].angle));
                    }
                }

                g2d.drawImage(enemy, (this.x - enemy_wid) / 2 - (enemy_wid / 2)
                        , (this.y - enemy_hei) / 2 - (enemy_hei / 2), null);
                for (Danmaku danmaku : danmakus) {
                    g2d.drawImage(bullet, danmaku.x, danmaku.y, null);
                    g2d.translate(danmaku.x + danmaku.width / 2,
                            danmaku.y + danmaku.height / 2);
                    g2d.rotate(danmaku.angle);
                    g2d.translate(-danmaku.x + danmaku.width / 2,
                            -danmaku.y + danmaku.height / 2);
                }

                /*
                for (int i = 0; i < danmakus.length; i++) {
                    g2d.drawImage(bullet,danmakus[i].x,danmakus[i].y,null);
                    g2d.rotate(danmakus[i+1].angle);
                    System.out.println("/");
                }
                 */
            }
            System.out.println(index);
            if (this.index == 2){
                System.out.println("??");
                for (int i = 0; i < danmakus.length; i++) {
                    danmakus[i] = new Danmaku(
                            ((this.x - enemy_wid) - bullet_wid) / 2 + 31 * i,
                            ((this.y - enemy_hei) - bullet_hei) / 2 + 30 * i,
                            1,
                            1);

                }

                for (int i = 0; i < danmakus.length; i++) {
                    danmakus[i].angle += Math.PI / 32 * (i * 2);
                    // 这⬆里⬇ 使用的公式是正弦定理:
                    if (danmakus[i].angle < Math.PI / 2) {
                        danmakus[i].vectorX = danmakus[i].speed *
                                Math.sin(danmakus[i].angle) /
                                Math.sin(Math.PI);
                        danmakus[i].vectorY = danmakus[i].speed *
                                Math.sin(Math.PI - danmakus[i].angle) /
                                Math.sin(Math.PI);
                    }
                }

                g2d.drawImage(enemy, (this.x - enemy_wid) / 2 - (enemy_wid / 2)
                        , (this.y - enemy_hei) / 2 - (enemy_hei / 2), null);
                //noinspection InfiniteLoopStatement
                while (true){
                    g2d.drawImage(bullet, danmakus[0].x, danmakus[0].y, null);
                    danmakus[0].x += danmakus[0].vectorX;
                    danmakus[0].y += danmakus[0].vectorY;
                    System.out.println("?");
                }

            }

        }
    }
}
