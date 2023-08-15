/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.utils;

/** Provides bit flag constants for alignment.
 *
 * @author Nathan Sweet */
public class Align {
	public static final int center = 1 << 0;
	public static final int top = 1 << 1;
	public static final int bottom = 1 << 2;
	public static final int left = 1 << 3;
	public static final int right = 1 << 4;

	public static final int topLeft = top | left;
	public static final int topRight = top | right;
	public static final int bottomLeft = bottom | left;
	public static final int bottomRight = bottom | right;

	public static final boolean isLeft (int align) {
		return (align & left) != 0;
	}

	public static final boolean isRight (int align) {
		return (align & right) != 0;
	}

	public static final boolean isTop (int align) {
		return (align & top) != 0;
	}

	public static final boolean isBottom (int align) {
		return (align & bottom) != 0;
	}

	public static final boolean isCenterVertical (int align) {
		return (align & top) == 0 && (align & bottom) == 0;
	}

	public static final boolean isCenterHorizontal (int align) {
		return (align & left) == 0 && (align & right) == 0;
	}

	public static String toString (int align) {
		StringBuilder buffer = new StringBuilder(13);
		if ((align & top) != 0)
			buffer.append("top,");
		else if ((align & bottom) != 0)
			buffer.append("bottom,");
		else
			buffer.append("center,");
		if ((align & left) != 0)
			buffer.append("left");
		else if ((align & right) != 0)
			buffer.append("right");
		else
			buffer.append("center");
		return buffer.toString();
	}
}
