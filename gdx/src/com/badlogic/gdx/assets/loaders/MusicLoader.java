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

package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import javax.annotation.Nullable;
import com.badlogic.gdx.NullUnmarked;

/** {@link AssetLoader} for {@link Music} instances. The Music instance is loaded synchronously.
 * @author mzechner */
public class MusicLoader extends AsynchronousAssetLoader<Music, MusicLoader.MusicParameter> {

	@Nullable private Music music;

	public MusicLoader (FileHandleResolver resolver) {
		super(resolver);
	}

	/** Returns the {@link Music} instance currently loaded by this {@link MusicLoader}.
	 * 
	 * @return the currently loaded {@link Music}, otherwise {@code null} if no {@link Music} has been loaded yet. */
	@Nullable
	protected Music getLoadedMusic () {
		return music;
	}

	@NullUnmarked
	@Override
	public void loadAsync (AssetManager manager, @Nullable String fileName, FileHandle file, @Nullable MusicParameter parameter) {
		music = Gdx.audio.newMusic(file);
	}

	@Nullable
	@Override
	public Music loadSync (AssetManager manager, @Nullable String fileName, FileHandle file, @Nullable MusicParameter parameter) {
		Music music = this.music;
		this.music = null;
		return music;
	}

	@Nullable
	@Override
	public Array<AssetDescriptor> getDependencies (@Nullable String fileName, FileHandle file,
		@Nullable MusicParameter parameter) {
		return null;
	}

	static public class MusicParameter extends AssetLoaderParameters<Music> {
	}

}
