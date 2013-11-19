/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.mvp.client.proxy;

/**
 * @author Philippe Beaudoin
 */
public class PlacesImpl implements Place {

    private final String[] nameTokens;

    public PlacesImpl(String... nameTokens) {
        this.nameTokens = nameTokens;
    }

    @Override
    public boolean canReveal() {
        return true;
    }

    @Override
    public final boolean equals(Object o) {
        if (o instanceof Place) {
            Place place = (Place) o;
            for (String nameToken : nameTokens) {
                if (nameToken.equals(place.getNameToken())) {
                    return true;
                }
            }
            return getNameToken().equals(place.getNameToken());
        }
        return false;
    }

    @Override
    public String getNameToken() {
        return nameTokens.toString();
    }

    @Override
    public final int hashCode() {
        return 17 * getNameToken().hashCode();
    }

    @Override
    public final boolean matchesRequest(PlaceRequest request) {
        for (String nameToken : nameTokens) {
            if (request.matchesNameToken(nameToken)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public final String toString() {
        return getNameToken();
    }

}
