/*
 * Copyright 2013 Jasig.
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
package com.turkcell.cas.oauth.client;

import org.apache.commons.lang3.StringUtils;
import org.scribe.up.profile.AttributesDefinitions;
import org.scribe.up.profile.linkedin.LinkedInAttributesDefinition;
import org.scribe.up.profile.linkedin.LinkedInProfile;

/**
 *
 * @author capacman
 */
public class LinkedInProvider extends org.scribe.up.provider.impl.LinkedInProvider {

    @Override
    protected LinkedInProfile extractUserProfile(final String body) {
        final LinkedInProfile profile = new LinkedInProfile();
        for (final String attribute : AttributesDefinitions.linkedinDefinition.getAllAttributes()) {
            final String value = StringUtils.substringBetween(body, "<" + attribute + ">", "</" + attribute + ">");
            profile.addAttribute(attribute, value);
            if (LinkedInAttributesDefinition.URL.equals(attribute)) {
                final String id = StringUtils.substringBetween(value, "id=", "&amp;authType=");
                profile.setId(id);
            }
        }
        return profile;
    }
}
