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

package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ColorAttribute extends Attribute {
	public static final String DiffuseAlias = "diffuseColor";
	public static final long Diffuse = register(DiffuseAlias);
	public static final String SpecularAlias = "specularColor";
	public static final long Specular = register(SpecularAlias);
	public static final String AmbientAlias = "ambientColor";
	public static final long Ambient = register(AmbientAlias);
	public static final String EmissiveAlias = "emissiveColor";
	public static final long Emissive = register(EmissiveAlias);
	public static final String ReflectionAlias = "reflectionColor";
	public static final long Reflection = register(ReflectionAlias);
	public static final String AmbientLightAlias = "ambientLightColor";
	public static final long AmbientLight = register(AmbientLightAlias);
	public static final String FogAlias = "fogColor";
	public static final long Fog = register(FogAlias);

	protected static long Mask = Ambient | Diffuse | Specular | Emissive | Reflection | AmbientLight | Fog;

	public static final boolean is (final long mask) {
		return (mask & Mask) != 0;
	}

	public static final ColorAttribute createAmbient (final Color color) {
		return new ColorAttribute(Ambient, color);
	}

	public static final ColorAttribute createAmbient (float r, float g, float b, float a) {
		return new ColorAttribute(Ambient, r, g, b, a);
	}

	public static final ColorAttribute createDiffuse (final Color color) {
		return new ColorAttribute(Diffuse, color);
	}

	public static final ColorAttribute createDiffuse (float r, float g, float b, float a) {
		return new ColorAttribute(Diffuse, r, g, b, a);
	}

	public static final ColorAttribute createSpecular (final Color color) {
		return new ColorAttribute(Specular, color);
	}

	public static final ColorAttribute createSpecular (float r, float g, float b, float a) {
		return new ColorAttribute(Specular, r, g, b, a);
	}

	public static final ColorAttribute createReflection (final Color color) {
		return new ColorAttribute(Reflection, color);
	}

	public static final ColorAttribute createReflection (float r, float g, float b, float a) {
		return new ColorAttribute(Reflection, r, g, b, a);
	}

	public static final ColorAttribute createEmissive (final Color color) {
		return new ColorAttribute(Emissive, color);
	}

	public static final ColorAttribute createEmissive (float r, float g, float b, float a) {
		return new ColorAttribute(Emissive, r, g, b, a);
	}

	public static final ColorAttribute createAmbientLight (final Color color) {
		return new ColorAttribute(AmbientLight, color);
	}

	public static final ColorAttribute createAmbientLight (float r, float g, float b, float a) {
		return new ColorAttribute(AmbientLight, r, g, b, a);
	}

	public static final ColorAttribute createFog (final Color color) {
		return new ColorAttribute(Fog, color);
	}

	public static final ColorAttribute createFog (float r, float g, float b, float a) {
		return new ColorAttribute(Fog, r, g, b, a);
	}

	public final Color color = new Color();

	public ColorAttribute (final long type) {
		super(type);
		if (!is(type)) throw new GdxRuntimeException("Invalid type specified");
	}

	public ColorAttribute (final long type, final Color color) {
		this(type);
		if (color != null) this.color.set(color);
	}

	public ColorAttribute (final long type, float r, float g, float b, float a) {
		this(type);
		this.color.set(r, g, b, a);
	}

	public ColorAttribute (final ColorAttribute copyFrom) {
		this(copyFrom.type, copyFrom.color);
	}

	@Override
	public Attribute copy () {
		return new ColorAttribute(this);
	}

	@Override
	public int hashCode () {
		int result = super.hashCode();
		result = 953 * result + color.toIntBits();
		return result;
	}

	@Override
	public int compareTo (Attribute o) {
		if (type != o.type) return (int)(type - o.type);
		return ((ColorAttribute)o).color.toIntBits() - color.toIntBits();
	}
}
