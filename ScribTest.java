//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;

//TODO: Need to figure out how to get invalid height and width values working properly now that sliders are implemented
public class ScribTest {
    @Test(expected = NumberFormatException.class)
    public void testHeightBadVal(){
        DrawTool draw = new DrawTool();
        draw.setHeight(0);
    }

    @Test(expected = NumberFormatException.class)
    public void testHeightBadVal2(){
        DrawTool draw = new DrawTool();
        draw.setHeight(818);
    }

    @Test
    public void testHeightGoodVal(){
        DrawTool draw = new DrawTool();
        draw.setHeight(30);
        assertEquals(draw.getHeight(), 30);
    }

    @Test(expected = NumberFormatException.class)
    public void testWidthBadVal(){
        DrawTool draw = new DrawTool();
        draw.setWidth(0);
    }

    @Test(expected = NumberFormatException.class)
    public void testWidthBadVal2(){
        DrawTool draw = new DrawTool();
        draw.setWidth(818);
    }

    @Test
    public void testWidthGoodVal(){
        DrawTool draw = new DrawTool();
        draw.setWidth(30);
        assertEquals(draw.getWidth(), 30);
    }

    @Test
    public void testDefaultColor(){
        DrawTool draw = new DrawTool();
        assertEquals(draw.getDrawColor(), Color.RED);
    }

    @Test
    public void testColorBlack(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.BLACK);
        assertEquals(draw.getDrawColor(), Color.BLACK);
    }

    @Test
    public void testColorRed(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.RED);
        assertEquals(draw.getDrawColor(), Color.RED);
    }

    @Test
    public void testColorOrange(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.ORANGE);
        assertEquals(draw.getDrawColor(), Color.ORANGE);
    }

    @Test
    public void testColorYellow(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.YELLOW);
        assertEquals(draw.getDrawColor(), Color.YELLOW);
    }

    @Test
    public void testColorGreen(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.GREEN);
        assertEquals(draw.getDrawColor(), Color.GREEN);
    }

    @Test
    public void testColorBlue(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.BLUE);
        assertEquals(draw.getDrawColor(), Color.BLUE);
    }

    @Test
    public void testColorMagenta(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.MAGENTA);
        assertEquals(draw.getDrawColor(), Color.MAGENTA);
    }

    @Test
    public void testColorWhite(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.WHITE);
        assertEquals(draw.getDrawColor(), Color.WHITE);
    }

    @Test
    public void testColorPink(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.PINK);
        assertEquals(draw.getDrawColor(), Color.PINK);
    }

    @Test
    public void testColorCyan(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.CYAN);
        assertEquals(draw.getDrawColor(), Color.CYAN);
    }

    @Test
    public void testColorLightGray(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.LIGHT_GRAY);
        assertEquals(draw.getDrawColor(), Color.LIGHT_GRAY);
    }

    @Test
    public void testColorDarkGray(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.DARK_GRAY);
        assertEquals(draw.getDrawColor(), Color.DARK_GRAY);
    }

}
