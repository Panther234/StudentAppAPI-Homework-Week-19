/*
 * Created By: Hiren Patel
 * Project Name: StudentApp-Serenity-Week-19
 */

package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class StudentGetTestWithSteps extends TestBase {

    @Steps
    StudentSteps studentSteps;

    @Title("This will get all Students info")
    @Test
    public void getAllStudentInfo() {
        studentSteps.getAllStudent().statusCode(200).log().all(); // get list of all students and validate statusCode
    }

    @Title("This will get single Student info by Id")
    @Test
    public void getSingleStudentInfo() {
        studentSteps.getStudentById(3).statusCode(200).log().all(); // get data of single student by ID and validate statusCode
    }

    @Title("This will search Students with Parameters")
    @Test
    public void searchStudentWithParameter() {
        studentSteps.getStudentByProgramme("Computer Science").statusCode(200).log().all();
    }

    @Title("This will search Students with Parameters and limit of students list")
    @Test
    public void searchStudentWithCourses() {
        studentSteps.getStudentWithLimit("Computer Science", 2).statusCode(200).log().all();
    }
}
