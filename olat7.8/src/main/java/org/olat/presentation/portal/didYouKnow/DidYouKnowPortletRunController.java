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
 * Copyright (c) 1999-2006 at Multimedia- & E-Learning Services (MELS),<br>
 * University of Zurich, Switzerland.
 * <p>
 */

package org.olat.presentation.portal.didYouKnow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.olat.lms.commons.i18n.I18nManager;
import org.olat.presentation.framework.core.UserRequest;
import org.olat.presentation.framework.core.components.Component;
import org.olat.presentation.framework.core.components.link.Link;
import org.olat.presentation.framework.core.components.link.LinkFactory;
import org.olat.presentation.framework.core.components.velocity.VelocityContainer;
import org.olat.presentation.framework.core.control.DefaultController;
import org.olat.presentation.framework.core.control.WindowControl;
import org.olat.presentation.framework.core.translator.PackageTranslator;
import org.olat.presentation.framework.core.translator.PackageUtil;
import org.olat.system.event.Event;

/**
 * Description:<br>
 * Run controller for the "did you know" portlet
 * <P>
 * Initial Date: 11.07.2005 <br>
 * 
 * @author gnaegi
 */
public class DidYouKnowPortletRunController extends DefaultController {

    private static final String VELOCITY_ROOT = PackageUtil.getPackageVelocityRoot(DidYouKnowPortlet.class);
    private PackageTranslator trans;
    private VelocityContainer didYouKnowVC;
    private int currentLookupPosition = 0;
    private List lookupList;
    private Link nextLink;

    /**
     * Internal constructor
     * 
     * @param ureq
     */
    protected DidYouKnowPortletRunController(UserRequest ureq, WindowControl wControl) {
        super(wControl);
        this.trans = new PackageTranslator(PackageUtil.getPackageName(DidYouKnowPortlet.class), ureq.getLocale());
        this.didYouKnowVC = new VelocityContainer("didYouKnowVC", VELOCITY_ROOT + "/didYouKnowPortlet.html", trans, this);
        nextLink = LinkFactory.createLink("next", didYouKnowVC, this);

        // get tips boundary initialize a shuffled list of all possible tip numbers
        int numbTips = -1;
        // search in property file from this package for all questions
        Properties propertiesFile = I18nManager.getInstance().getResolvedProperties(trans.getLocale(), trans.getPackageName());
        Set keys = propertiesFile.keySet();
        for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            // Questions start with 'Q-'
            if (key.startsWith("Q-"))
                numbTips++;
        }
        lookupList = new ArrayList();
        for (int i = 0; i < numbTips; i++) {
            lookupList.add(new Integer(i));
        }
        Collections.shuffle(lookupList);

        // calculate the next tip number
        addNextQuestionToVelocity();

        setInitialComponent(this.didYouKnowVC);
    }

    /**
	 */
    @Override
    protected void event(UserRequest ureq, Component source, Event event) {
        if (source == nextLink) {
            addNextQuestionToVelocity();
        }
    }

    /**
     * Gets the question from the translation files and puhses it to velocity
     */
    private void addNextQuestionToVelocity() {
        if (lookupList.size() == 0) {
            this.didYouKnowVC.contextPut("questionId", -1);
        } else {
            // reset and start from 0 when reaching the end
            if (currentLookupPosition == lookupList.size()) {
                currentLookupPosition = 0;
            }
            // get question and answer for given id
            Integer questionId = (Integer) lookupList.get(currentLookupPosition);
            this.didYouKnowVC.contextPut("questionId", questionId);
            // update position
            currentLookupPosition++;
        }
    }

    /**
	 */
    @Override
    protected void doDispose() {
        // nothing to dispose
    }

}
