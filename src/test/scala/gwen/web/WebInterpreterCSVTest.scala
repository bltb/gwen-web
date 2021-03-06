/*
 * Copyright 2015 Brady Wood, Branko Juric
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gwen.web

class WebInterpreterCSVTest extends WebInterpreterTest {

  "Dry run CSV data-driven feature" should "pass" in {
    evaluate(List("features/csvdriven/FloodIO.feature"), false, true, "target/reports/dryrun-csvdriven-1", None)  // will auto discover csv in same folder
    evaluate(List("features/csvdriven/FloodIO.feature"), false, true, "target/reports/dryrun-csvdriven-2", Some("features/csvdriven/FloodIO.csv"))
  }
  
  "Sequential CSV data-driven feature" should "evaluate" in {
    evaluate(List("features/csvdriven/FloodIO.feature"), false, false, "target/reports/sequential-csvdriven", Some("features/csvdriven/FloodIO.csv"))
  }
  
  "Parallel CSV data-driven feature" should "evaluate" in {
    evaluate(List("features/csvdriven/FloodIO.feature"), true, false, "target/reports/parallel-csvdriven", None) // will auto discover csv in same folder
  }
  
}