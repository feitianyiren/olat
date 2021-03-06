/**
 * OLAT - Online Learning and Training<br>
 * http://www.olat.org
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); <br>
 * you may not use this file except in compliance with the License.<br>
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,<br>
 * software distributed under the License is distributed on an "AS IS" BASIS, <br>
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. <br>
 * See the License for the specific language governing permissions and <br>
 * limitations under the License.
 * <p>
 * Copyright (c) 1999-2008 at frentix GmbH, Switzerland, http://www.frentix.com
 * <p>
 */
package org.olat.presentation.i18n.devtools;

import org.olat.lms.commons.i18n.I18nModule;
import org.olat.lms.commons.i18n.devtools.TranslationDevManager;
import org.olat.presentation.framework.core.UserRequest;
import org.olat.presentation.framework.core.components.Component;
import org.olat.presentation.framework.core.components.velocity.VelocityContainer;
import org.olat.presentation.framework.core.control.WindowControl;
import org.olat.presentation.framework.core.control.controller.MainLayoutBasicController;
import org.olat.system.event.Event;

/**
 * Description:<br>
 * TODO: rhaag Class Description for TranslationDevMainController
 * <P>
 * Initial Date: 23.09.2008 <br>
 * 
 * @author Roman Haag, frentix GmbH, roman.haag@frentix.com
 */
public class TranslationDevMainController extends MainLayoutBasicController {
    private VelocityContainer vc;
    private TranslationDevManager tDMan;

    /**
     * @param ureq
     * @param control
     */
    public TranslationDevMainController(UserRequest ureq, WindowControl control) {
        super(ureq, control);
        vc = createVelocityContainer("translationdev");
        tDMan = TranslationDevManager.getInstance();
        String srcPath = I18nModule.getTransToolApplicationLanguagesSrcDir().getAbsolutePath();
        vc.contextPut("srcPath", srcPath);
        // TODO RH: check for enabled debug-mode in order to prevent caching!
        // vc.contextPut("cachingDisabled", I18nModule.isCachingEnabled());

        // formFactory.addTextElement(name, maxLen, initialValue, i18nLabel, formItemContainer)
        putInitialPanel(vc);
    }

    /**
	 */
    @Override
    protected void doDispose() {
        // TODO Auto-generated method stub

    }

    /**
	 */
    @Override
    protected void event(UserRequest ureq, Component source, Event event) {
        // TODO Auto-generated method stub

    }

}
