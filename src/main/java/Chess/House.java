package Chess;

import java.awt.*;

public class House {

    int x,y;

    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint (Graphics page) {
        page.drawRect(x, y, 40, 40);
        page.drawLine(x, y, x+20, y-20);
        page.drawLine(x+40, y, x+20, y-20);
    }

}
