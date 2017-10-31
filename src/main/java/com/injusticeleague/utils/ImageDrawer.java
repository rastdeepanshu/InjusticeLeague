package com.injusticeleague.utils;

import java.awt.*;
import java.awt.image.BufferedImage;


public class ImageDrawer {

	/**
	 * Prints ascii image
	 * @param text Text whose ascii image you want to draw
	 */
	public void printAsciiImage(String text) {
		BufferedImage image = new BufferedImage(Constants.WIDTH, Constants.HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setFont(new Font("Serif", Font.ITALIC, 20));

		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics2d.drawString(text, 10, 20);

		for (int y = 0; y < Constants.HEIGHT; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < Constants.WIDTH; x++) {
				sb.append(image.getRGB(x, y) == -16777216 ? " " : "#");
			}
			if (sb.toString().trim().isEmpty()) {
				continue;
			}
			System.out.println(sb);
		}
		System.out.println(); // New line to have some extra space to make it appear good.
	}
}
