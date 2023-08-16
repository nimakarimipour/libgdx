
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.google.gwt.user.client.Window.Navigator;

public class UIUtils {
	public static boolean isAndroid = Navigator.getPlatform().contains("Android");
	public static boolean isMac = Navigator.getPlatform().contains("Mac");
	public static boolean isWindows = Navigator.getPlatform().contains("Win");
	public static boolean isLinux = Navigator.getPlatform().contains("Linux") || Navigator.getPlatform().contains("FreeBSD");
	public static boolean isIos = Navigator.getPlatform().contains("iPhone") || Navigator.getPlatform().contains("iPod")
		|| Navigator.getPlatform().contains("iPad");

	public static boolean left () {
		return Gdx.input.isButtonPressed(Buttons.LEFT);
	}

	public static boolean left (int button) {
		return button == Buttons.LEFT;
	}

	public static boolean right () {
		return Gdx.input.isButtonPressed(Buttons.RIGHT);
	}

	public static boolean right (int button) {
		return button == Buttons.RIGHT;
	}

	public static boolean middle () {
		return Gdx.input.isButtonPressed(Buttons.MIDDLE);
	}

	public static boolean middle (int button) {
		return button == Buttons.MIDDLE;
	}

	public static boolean shift () {
		return Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT);
	}

	public static boolean shift (int keycode) {
		return keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT;
	}

	public static boolean ctrl () {
		if (isMac)
			return Gdx.input.isKeyPressed(Keys.SYM);
		else
			return Gdx.input.isKeyPressed(Keys.CONTROL_LEFT) || Gdx.input.isKeyPressed(Keys.CONTROL_RIGHT);
	}

	public static boolean ctrl (int keycode) {
		if (isMac)
			return keycode == Keys.SYM;
		else
			return keycode == Keys.CONTROL_LEFT || keycode == Keys.CONTROL_RIGHT;
	}

	public static boolean alt () {
		return Gdx.input.isKeyPressed(Keys.ALT_LEFT) || Gdx.input.isKeyPressed(Keys.ALT_RIGHT);
	}

	public static boolean alt (int keycode) {
		return keycode == Keys.ALT_LEFT || keycode == Keys.ALT_RIGHT;
	}
}
