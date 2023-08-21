package utilz;

public class Constants{
	
	public static class Direction {
		public static final int DOWN = 0;
		public static final int LEFT = 1;
		public static final int RIGHT = 2;
		public static final int UP = 3;
		
		public static int GetSpriteAmount(int player_action) {
			switch(player_action) {
			case DOWN:
			case LEFT:
			case RIGHT:
			case UP:
			default :
				return 3;
			}
			
		}
	}
	
}
