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
 * Copyright (c) since 2004 at Multimedia- & E-Learning Services (MELS),<br>
 * University of Zurich, Switzerland.
 * <p>
 */
package org.olat.presentation.ims.qti.editor.localstrings;

import org.olat.lms.ims.qti.editor.localstrings.QtiEditorLocalStrings;
import org.olat.presentation.framework.core.translator.Translator;

/**
 * Initial Date: 11.10.2011 <br>
 * 
 * @author Branislav Balaz
 */
public abstract class QtiEditorLocalStringsAbstractFactory {

    protected final String NEW_SECTION = "editor.newsection";
    protected final String NEW_QUESTION = "editor.newquestion";
    protected final String NEW_QUESTION_TEXT = "editor.newquestiontext";
    protected final String NEW_RESPONSE_TEXT = "editor.newresponsetext";
    protected final String NEW_TEXT_ELEMENT = "editor.newtextelement";
    protected final Translator translator;

    QtiEditorLocalStringsAbstractFactory(Translator translator) {
        this.translator = translator;
    }

    abstract public QtiEditorLocalStrings createLocalStrings();

}
