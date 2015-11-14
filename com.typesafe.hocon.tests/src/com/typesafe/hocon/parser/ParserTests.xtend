package com.typesafe.hocon.parser

import com.typesafe.config.HoconInjectorProvider
import com.typesafe.config.hocon.Root
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(HoconInjectorProvider)
@RunWith(XtextRunner)
class ParserTests {
  
  @Inject
  ParseHelper<Root> parser
  
  @Test
  def void parseSimpleJson() {
    succeeds('''
      "foo": 10.0,
      "bar": "baz",
      "obj": {
        "a": 10,
        "b": [1, 2, 3],
        "c": true,
        "d": false
      } 
    ''')
  }
  
  @Test
  def void parseSimpleHocon() {
    succeeds('''
    a = true
    b = false
    c: on
    foo = 5seconds
    port = 1024
    # this one is also a comment
    // as is this one
    outer {
      inner {
        value = 10 # this is an example
        bar = -100,
        
        # and another
        array = [
          1, 2, 3
        ]
        long =
          "foo"
      }
    }
    ''')
  }
  
  // taken from the typesafe config test suite
  @Test
  def void complexHocon() {
    succeeds('''
    {
          foo: bar baz    qux    ernie
          // The above was a concatenation

          baz   =   [ abc 123, {a:12
                                b: {
                                  c: 13
                                  d: {
                                    a: 22
                                    b: "abcdefg" # this is a comment
                                    c: [1, 2, 3]
                                  }
                                }
                                }, # this was an object in an array
                                //The above value is a map containing a map containing a map, all in an array
                                22,
                                // The below value is an array contained in another array
                                [1,2,3]]
          // This is a map with some nested maps and arrays within it, as well as some concatenations
          qux {
            baz: abc 123
            bar: {
              baz: abcdefg
              bar: {
                a: null
                b:  true
                c: [true  false 123, null, [1, 2, 3]]
              }
            }
          }
        // Did I cover everything?
        }
    ''')
  }
  
  private def void succeeds(String text) {
    val model = parser.parse(text)
    Assert.assertTrue("No errors expected, but errors found: " + model.eResource.errors, model.eResource.errors.empty)
  }
}