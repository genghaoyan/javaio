package coin;

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   
   private int graph_Bottom;
   private int bar_Left;
   private int bar_Width;
   private double draw_Scale;           //the application units
   private int bar_Height;             //height of the bar in application units
   private int bar_Height_In_Pixels;      //height of the bar in pixels
   private Color bar_Color;
   private String label_String;
   
   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) {
      graph_Bottom = bottom;  //底部位置
      bar_Left = left;  //左边位置
      bar_Width = width;  //宽度
      bar_Height = barHeight;  //柱形图的高度
      draw_Scale = scale;  //程序单位与像素之间的比例
      bar_Height_In_Pixels = (int)Math.round(bar_Height * scale); //计算柱形图的高度所应占的像素
      bar_Color = color; //柱形图的颜色
      label_String = label;  //标签文本
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
      //Get the dimensions of the label to display
      Font font = g2.getFont(); //获取g2字体
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(label_String, context);
      int label_Width = (int) labelBounds.getWidth();
      int label_Height = (int) labelBounds.getHeight();
      
      //Draw the label
      g2.setColor(Color.BLACK);
      g2.drawString(label_String, bar_Left + bar_Width / 2 - label_Width / 2, graph_Bottom);// 该方法接受三个参数：要绘制的字符串、绘制的起点 x 坐标、绘制的起点 y 坐标。这里的起点 x 坐标为 (bar_Left + bar_Width / 2 - label_Width / 2)，即横向居中对齐；起点 y 坐标为 graph_Bottom，即在柱状图的底部。
      
      //Draw and fill the bar
      g2.setColor(bar_Color);
      Rectangle bar = new Rectangle(bar_Left, graph_Bottom - label_Height - bar_Height_In_Pixels, bar_Width, bar_Height_In_Pixels); //创建一个 Rectangle 对象 bar，其左上角坐标为 (bar_Left, graph_Bottom - label_Height - bar_Height_In_Pixels)，宽度为 bar_Width，高度为 bar_Height_In_Pixels。
      g2.fill(bar);
   }
}
