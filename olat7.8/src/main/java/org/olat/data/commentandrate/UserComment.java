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
 * Copyright (c) frentix GmbH<br>
 * http://www.frentix.com<br>
 * <p>
 */
package org.olat.data.commentandrate;

import org.olat.data.basesecurity.Identity;
import org.olat.data.commons.database.CreateInfo;
import org.olat.data.commons.database.Persistable;

import java.util.Date;

/**
 * Description:<br>
 * The user comment object represents a comment of a user about an OLAT resource. A user can have multipte comments for a resource. A comment can have a parent comment
 * which means that the comment is a reply.
 * <P>
 * Initial Date: 23.11.2009 <br>
 * 
 * @author gnaegi
 */
public interface UserComment extends CreateInfo, Persistable {

    /**
     * @return The OLAT resource type name of the resource which is beeing commented
     */
    public String getResName();

    /**
     * @return The OLAT resource id of the resource which is beeing commented
     */
    public Long getResId();

    /**
     * @return An optional String to precisely define the resource if the resource name and resource type id is not enough. Returns NULL if not defined.
     */
    public String getResSubPath();

    /**
     * @return The Author of this comment.
     */
    public Identity getCreator();

    /**
     * @param creator
     *            The author of the comment
     */
    public void setCreator(Identity creator);

    /**
     * @return The comment text
     */
    public String getComment();

    /**
     * @param commentText
     *            The comment text
     */
    public void setComment(String commentText);

    /**
     * @return The parent comment if available or NULL if comment has no parent
     */
    public UserComment getParent();

    /**
     * @param parentComment
     *            The parent comment if this is a reply
     */
    public void setParent(UserComment parentComment);

    public void setCreationDate(Date date);
}
