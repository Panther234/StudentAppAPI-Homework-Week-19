/*
 * Created By: Hiren Patel
 * Project Name: StudentApp-Serenity-Week-19
 */

package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class StudentCRUDTestWithSteps extends TestBase {

    static String firstName = "Harry" + TestUtils.getRandomValue();
    static String lastName = "Patel" + TestUtils.getRandomValue();
    static String programme = "Pharmacy";
    static String email = "Harry@gmail.com" + TestUtils.getRandomValue();
    static int studentId;

    @Steps
    StudentSteps studentSteps;

    @Title("This will create a new student")
    @Test
    public void test001(){
        List<String> courseList = new ArrayList<>();
        courseList.add("Anatomy");
        courseList.add("Medicine");
        ValidatableResponse response = studentSteps.createStudent(firstName, lastName, email, programme, courseList);
        response.log().all().statusCode(201);
    }

    @Title("Verify if the student was added to the application")
    @Test
    public void test002() {
        HashMap<String, Object> value = studentSteps.getStudentInfoByFirstname(firstName);
        Assert.assertThat(value, hasValue(firstName));
        studentId = (int) value.get("id");
    }

    @Title("Update the user information and verify the updated information")
    @Test
    public void test003() {
        firstName = firstName + "_updated";
        List<String> courseList = new ArrayList<>();
        courseList.add("Generic Medicine");
        courseList.add("Human Body");
        studentSteps.updateStudent(studentId, firstName, lastName, email, programme, courseList).log().all().statusCode(200);
        HashMap<String, Object> value = studentSteps.getStudentInfoByFirstname(firstName);
        Assert.assertThat(value, hasValue(firstName));
    }

    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004() {
        studentSteps.deleteStudent(studentId).statusCode(204);
        studentSteps.getStudentById(studentId).statusCode(404);
    }

}
