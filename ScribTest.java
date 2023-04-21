//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Testing the software, test color values for width and height for correct values.
 */
public class ScribTest {

    /**
     * Test if the height can be set to zero, should throw error
     */
    @Test(expected = NumberFormatException.class)
    public void testHeightBadVal(){
        DrawTool draw = new DrawTool();
        draw.setHeight(0);
    }

    /**
     * test if the height can be set to 818, out of bounds should throw error.
     */
    @Test(expected = NumberFormatException.class)
    public void testHeightBadVal2(){
        DrawTool draw = new DrawTool();
        draw.setHeight(818);
    }

    /**
     * test correct height input, should test correctly.
     */
    @Test
    public void testHeightGoodVal(){
        DrawTool draw = new DrawTool();
        draw.setHeight(30);
        assertEquals(draw.getHeight(), 30);
    }

    /**
     * test invalid width input, should throw error
     */
    @Test(expected = NumberFormatException.class)
    public void testWidthBadVal(){
        DrawTool draw = new DrawTool();
        draw.setWidth(0);
    }

    /**
     * test invalid width input should throw error
     */
    @Test(expected = NumberFormatException.class)
    public void testWidthBadVal2(){
        DrawTool draw = new DrawTool();
        draw.setWidth(818);
    }

    /**
     * test correct inout value for width, should run smoothly
     */
    @Test
    public void testWidthGoodVal(){
        DrawTool draw = new DrawTool();
        draw.setWidth(30);
        assertEquals(draw.getWidth(), 30);
    }

    /**
     * test setting the  default draw color to red
     */
    @Test
    public void testDefaultColor(){
        DrawTool draw = new DrawTool();
        assertEquals(draw.getDrawColor(), Color.RED);
    }

    /**
     * test setting the draw color to black
     */
    @Test
    public void testColorBlack(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.BLACK);
        assertEquals(draw.getDrawColor(), Color.BLACK);
    }

    /**
     * test setting the draw color to red
     */
    @Test
    public void testColorRed(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.RED);
        assertEquals(draw.getDrawColor(), Color.RED);
    }

    /**
     * test setting the draw color to orange
     */
    @Test
    public void testColorOrange(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.ORANGE);
        assertEquals(draw.getDrawColor(), Color.ORANGE);
    }

    /**
     * test setting the draw color to yellow
     */
    @Test
    public void testColorYellow(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.YELLOW);
        assertEquals(draw.getDrawColor(), Color.YELLOW);
    }

    /**
     * test setting the draw color to green
     */
    @Test
    public void testColorGreen(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.GREEN);
        assertEquals(draw.getDrawColor(), Color.GREEN);
    }

    /**
     * test setting the draw color to blue
     */
    @Test
    public void testColorBlue(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.BLUE);
        assertEquals(draw.getDrawColor(), Color.BLUE);
    }
    /**
     * test setting the draw color to magenta
     */
    @Test
    public void testColorMagenta(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.MAGENTA);
        assertEquals(draw.getDrawColor(), Color.MAGENTA);
    }

    /**
     * test setting the draw color to white
     */
    @Test
    public void testColorWhite(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.WHITE);
        assertEquals(draw.getDrawColor(), Color.WHITE);
    }

    /**
     * test setting the draw color to pink
     */
    @Test
    public void testColorPink(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.PINK);
        assertEquals(draw.getDrawColor(), Color.PINK);
    }

    /**
     * test setting the draw color to cyan
     */
    @Test
    public void testColorCyan(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.CYAN);
        assertEquals(draw.getDrawColor(), Color.CYAN);
    }

    /**
     * test setting the draw color to light grey
     */
    @Test
    public void testColorLightGray(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.LIGHT_GRAY);
        assertEquals(draw.getDrawColor(), Color.LIGHT_GRAY);
    }

    /**
     * test setting the draw color to dark grey
     */
    @Test
    public void testColorDarkGray(){
        DrawTool draw = new DrawTool();
        draw.setColor(Color.DARK_GRAY);
        assertEquals(draw.getDrawColor(), Color.DARK_GRAY);
    }

}
