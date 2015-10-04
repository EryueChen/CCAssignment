package chapter5;

public class Solution08 {
	//Add the full bytes that are all drawn with 1
	//Add the first and end byte that are partly drawn.
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int first_full_byte = x1 / 8;
		int first_offset = x1 % 8;
		if (first_offset != 0) first_full_byte++;
		int end_full_byte = x2 / 8;
		int end_offset = x2 / 8;
		if (end_offset != 7) end_full_byte--;
		for (int i = first_full_byte; i<= end_full_byte; i++) {
			screen[(width / 8) * y + i] = (byte) 0xFF;
		}
		byte first = (byte) (0xFF >> first_offset);
		byte end = (byte) ~(0xFF >> (end_offset + 1));
		if (x1 / 8 == x2 / 8) {
			byte mask = (byte) (first & end);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (first_offset != 0) {
				int byte_num = (width / 8) * y + first_full_byte - 1;
				screen[byte_num] |= first;
			}
			if (end_offset != 7) {
				int byte_num = (width / 8) * y + end_full_byte + 1;
				screen[byte_num] |= end;
			}
		}
	}
	
	public static String toBinary(byte bytes) {
	    StringBuilder sb = new StringBuilder(Byte.SIZE);
	    for( int i = 0; i < Byte.SIZE; i++ )
	        sb.append((bytes << i & 0x80) == 0 ? '0' : '1');
	    return sb.toString();
	}

	public static void main(String[] args) {
		byte[] screen = new byte[16];
		drawLine(screen, 32, 12, 24, 2);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++){
				System.out.print(toBinary(screen[4 * i + j]));
			}
			System.out.println();
		}
	}

}
