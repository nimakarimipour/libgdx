package com.badlogic.gdx.assets.loaders.resolvers;

import javax.annotation.Nullable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

public class LocalFileHandleResolver implements FileHandleResolver {

    @Override
    public FileHandle resolve(String fileName) {
        return Gdx.files.local(fileName);
    }
}
