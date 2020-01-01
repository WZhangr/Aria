/*
 * Copyright (C) 2016 AriaLyy(https://github.com/AriaLyy/Aria)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arialyy.aria.ftp.upload;

import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.loader.AbsNormalLoader;
import com.arialyy.aria.core.loader.AbsNormalLoaderUtil;
import com.arialyy.aria.core.loader.LoaderStructure;
import com.arialyy.aria.core.loader.NormalThreadStateManager;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.ftp.FtpRecordHandler;
import com.arialyy.aria.ftp.FtpTaskOption;

/**
 * @Author lyy
 * @Date 2019-09-19
 */
public final class FtpULoaderUtil extends AbsNormalLoaderUtil {

  public FtpULoaderUtil(AbsTaskWrapper wrapper, IEventListener listener) {
    super(wrapper, listener);
    wrapper.generateTaskOption(FtpTaskOption.class);
  }

  @Override public AbsNormalLoader getLoader() {
    return mLoader == null ? new FtpULoader(getTaskWrapper(), getListener()) : mLoader;
  }

  @Override public LoaderStructure BuildLoaderStructure() {
    LoaderStructure structure = new LoaderStructure();
    structure.addComponent(new FtpRecordHandler(getTaskWrapper()))
        .addComponent(new NormalThreadStateManager(getListener()))
        .addComponent(new FtpUFileInfoTask((UTaskWrapper) getTaskWrapper()))
        .addComponent(new FtpUTTBuilder(getTaskWrapper()));
    structure.accept(getLoader());
    return structure;
  }
}
