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
package org.olat.lms.core.notification.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.olat.lms.core.notification.PublisherTypeHandler;
import org.olat.lms.core.notification.service.PublisherData;
import org.olat.presentation.forum.ForumNotificationTypeHandler;
import org.olat.presentation.wiki.WikiNotificationTypeHandler;

/**
 * Initial Date: 29.03.2012 <br>
 * 
 * @author guretzki
 */
public class PublisherTypeHandlerSelectorTest {

    private PublisherTypeHandlerSelector typeHandlerSelectorTestObject;

    @Before
    public void setup() {
        Set<PublisherTypeHandler> typeHandler = new HashSet<PublisherTypeHandler>();
        typeHandler.add(new ForumNotificationTypeHandler());
        typeHandler.add(new WikiNotificationTypeHandler());

        typeHandlerSelectorTestObject = new PublisherTypeHandlerSelector();
        typeHandlerSelectorTestObject.notificationTypeHandler = typeHandler;
    }

    @Test
    public void getTypeHandlerFrom_Forum() {
        PublisherData publisherData = mock(PublisherData.class);
        when(publisherData.getType()).thenReturn("Forum");
        PublisherTypeHandler forumTypeHandler = typeHandlerSelectorTestObject.getTypeHandlerFrom(publisherData);
        assertNotNull("Could not found NotificationTypeHandler for 'forum'", forumTypeHandler);
        assertTrue("Wrong type-handler for forum", forumTypeHandler instanceof ForumNotificationTypeHandler);
    }

    @Test
    public void getTypeHandlerFrom_Wiki() {
        PublisherData publisherData = mock(PublisherData.class);
        when(publisherData.getType()).thenReturn("WikiPage");
        PublisherTypeHandler wikiTypeHandler = typeHandlerSelectorTestObject.getTypeHandlerFrom(publisherData);
        assertNotNull("Could not found NotificationTypeHandler for 'wiki'", wikiTypeHandler);
        assertTrue("Wrong type-handler for forum", wikiTypeHandler instanceof WikiNotificationTypeHandler);
    }

}
