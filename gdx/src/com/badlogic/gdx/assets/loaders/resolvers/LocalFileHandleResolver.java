
package com.badlogic.gdx.assets.loaders.resolvers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import javax.annotation.Nullable;
import com.badlogic.gdx.NullUnmarked;

public class LocalFileHandleResolver implements FileHandleResolver {
	@NullUnmarked
	@Override
	public FileHandle resolve (@Nullable String fileName) {
		return Gdx.files.local(fileName);
	}
}
