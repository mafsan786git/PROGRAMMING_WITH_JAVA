import java.util.*;
public class CoursesSchedule207 {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{
            {0,1}, {0,2}, {1,2}
        };
        canFinish(3,prerequisites);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        List<Set<Integer>> courses = new ArrayList<>();
        for(int index = 0 ; index < numCourses ; index++){
            courses.add(new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            int firstCourse = prerequisite[0];
            int secondCourse = prerequisite[1];
            if(firstCourse == secondCourse) return false;
            Set<Integer> dependency = courses.get(secondCourse);
            if (!dependency.isEmpty() && dependency.contains(firstCourse)){
                return false;
            }
            Set<Integer> dependent =  courses.get(firstCourse);
            if(dependent == null){
                dependent = new HashSet<>();
            }
            dependent.add(secondCourse);
            courses.set(firstCourse,dependent);
        }
        return true;
    }
}