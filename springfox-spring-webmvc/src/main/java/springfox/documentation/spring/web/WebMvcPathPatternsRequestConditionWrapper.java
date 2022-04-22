/*
 *
 *  Copyright 2015 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package springfox.documentation.spring.web;

import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;

import java.util.Set;
import java.util.stream.Collectors;

import static springfox.documentation.spring.web.paths.Paths.maybeChompLeadingSlash;
import static springfox.documentation.spring.web.paths.Paths.maybeChompTrailingSlash;

public class WebMvcPathPatternsRequestConditionWrapper
    implements springfox.documentation.spring.wrapper.PathPatternsRequestCondition<PathPatternsRequestCondition> {

  private final String contextPath;
  private final PathPatternsRequestCondition condition;

  public WebMvcPathPatternsRequestConditionWrapper(
      String contextPath,
      PathPatternsRequestCondition condition) {

    this.contextPath = contextPath;
    this.condition = condition;
  }

  @Override
  public springfox.documentation.spring.wrapper.PathPatternsRequestCondition combine(
      springfox.documentation.spring.wrapper.PathPatternsRequestCondition<PathPatternsRequestCondition> other) {
    if (other instanceof WebMvcPathPatternsRequestConditionWrapper && !this.equals(other)) {
      return new WebMvcPathPatternsRequestConditionWrapper(
              contextPath,
              condition.combine(((WebMvcPathPatternsRequestConditionWrapper) other).condition));
    }
    return this;
  }

  @Override
  public Set<String> getPatterns() {
    return condition.getPatterns().stream().map(x->x.getPatternString()).collect(Collectors.toSet()).stream()
        .map(p -> String.format("%s/%s", maybeChompTrailingSlash(contextPath),  maybeChompLeadingSlash(p)))
        .collect(Collectors.toSet());
  }


  @Override
  public boolean equals(Object o) {
    if (o instanceof WebMvcPathPatternsRequestConditionWrapper) {
      return this.condition.equals(((WebMvcPathPatternsRequestConditionWrapper) o).condition);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return this.condition.hashCode();
  }


  @Override
  public String toString() {
    return this.condition.toString();
  }
}

