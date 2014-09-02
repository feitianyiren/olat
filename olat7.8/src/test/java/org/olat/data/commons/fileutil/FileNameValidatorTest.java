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
package org.olat.data.commons.fileutil;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Initial Date: 22.08.2012 <br>
 * 
 * @author aabouc
 */
public class FileNameValidatorTest {

    @Test
    public void validate_true() {
        assertTrue(FileNameValidator.validate("this_is_valid_file_name..."));
        assertTrue(FileNameValidator.validate("...this_is_valid_file_name..."));
        assertTrue(FileNameValidator.validate("this_is_valid_file_name...ä"));
    }

    @Test
    public void validate_false() {
        assertFalse(FileNameValidator.validate("..this_is_valid_file_name"));
        assertFalse(FileNameValidator.validate("..this_is_valid_file_name..."));
        assertFalse(FileNameValidator.validate("//this_is_valid_file_name..."));
    }

}
