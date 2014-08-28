package mod.dayz;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Controls {
	
	public static Controls[] keyList = new Controls[16];
	/*    */ 
	/* 10 */   public static Controls zoomKey = new Controls(1, "BUTTON0", "Gun Zoom", true);
	/* 11 */   public static Controls reloadKey = new Controls(2, "R", "Reload Gun", false);
	/* 12 */   public static Controls holdbreathKey = new Controls(3, "LCONTROL", "Hold Breath", false);
	/* 13 */   public static Controls playerzoomKey = new Controls(4, "LCONTROL", "Player Zoom", false);
	/* 14 */   public static Controls shootKey = new Controls(5, "BUTTON1", "Fire Gun", true);
	/* 15 */   public static Controls fireSelectKey = new Controls(6, "F", "Fire Selector", false);
	/* 16 */   public static Controls killfeedKey = new Controls(7, "TAB", "Kill Feed", false);
	/*    */   public int id;
	/*    */   private String key;
	/*    */   private String action;
	/*    */   public boolean mouse;
	/*    */ 
	/*    */   public Controls(int id, String key, String ac, boolean m)
	/*    */   {
	/* 25 */     this.id = id;
	/* 26 */     this.key = key;
	/* 27 */     this.action = ac;
	/* 28 */     if (keyList[id] == null)
	/*    */     {
	/* 30 */       keyList[id] = this;
	/*    */     }
	/* 32 */     this.mouse = m;
	/*    */   }
	/*    */ 
	/*    */   public String getKeyActionString()
	/*    */   {
	/* 37 */     return this.action;
	/*    */   }
	/*    */ 
	/*    */   public int getKey()
	/*    */   {
	/* 42 */     return Keyboard.getKeyIndex(this.key);
	/*    */   }
	/*    */ 
	/*    */   public void setKeyBind(String var1)
	/*    */   {
	/* 47 */     this.key = var1;
	/*    */   }
	/*    */ 
	/*    */   public String getKeyString()
	/*    */   {
	/* 52 */     return this.key;
	/*    */   }
	/*    */ 
	/*    */   public boolean isKeyDown()
	/*    */   {
	/* 57 */     if (this.mouse == true)
	/*    */     {
	/* 59 */       if (Mouse.isButtonDown(Mouse.getButtonIndex(getKeyString())))
	/*    */       {
	/* 61 */         return true;
	/*    */       }
	/*    */ 
	/*    */     }
	/* 65 */     else if (Keyboard.isKeyDown(getKey()))
	/*    */     {
	/* 67 */       return true;
	/*    */     }
	/*    */ 
	/* 71 */     return false;
	/*    */   }

			}
