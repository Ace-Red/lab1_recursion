package recfun

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MySuite extends AnyFunSuite {
  import Main.indTask
  test("fun: test 1") {
    assert(indTask(1.2f, 123.5f) === 123.5f)
  }

  test("fun: test 2") {
    assert(indTask(3, 2) === 12)
  }

  test("fun: test 3") {
    assertThrows[Exception]{
      indTask(3.2f, 2)
    }
  }

  test("fun: test 4") {
    assertThrows[Exception]{
      indTask(2, 7)
    }
  }

  test("fun: test 5") {
    assert(indTask(16, 2) === 2.14748368E8)
  }

}
