


public class WeeklySchedule {
	DailyTask task = DailyTask.START;
	// imagine you j=have to do certain tasks a certain order
	public WeeklySchedule wakeUp(){
		if(task != DailyTask.START){
			System.out.println("The task is out of Order. The expected task is "+ DailyTask.START.toString());
		}
		else{
			System.out.println( "Completed task "+ DailyTask.WAKEUP.toString());
			task = DailyTask.WAKEUP;
		}

		return this;
	}
	public WeeklySchedule haveBreakFast(){
		if(task != DailyTask.WAKEUP){
			System.out.println("The task is out of Order. The expected task is "+ DailyTask.WAKEUP.toString());
		}
		else{
			System.out.println( "Completed task "+ DailyTask.BREAKFAST.toString());
			task = DailyTask.BREAKFAST;
		}

		return this;
	}
	public WeeklySchedule goAndPlay(){
		if(task != DailyTask.BREAKFAST){
			System.out.println("The task is out of Order. The expected task is "+ DailyTask.BREAKFAST.toString());
		}
		else{
			System.out.println( "Completed task "+ DailyTask.SPORT_ACTIVITY.toString());
			task = DailyTask.SPORT_ACTIVITY;
		}

		return this;
	}
	public WeeklySchedule gotoWork(){
		if(task != DailyTask.SPORT_ACTIVITY){
			System.out.println("The task is out of Order. The expected task is "+ DailyTask.SPORT_ACTIVITY.toString());
		}
		else{
			System.out.println( "Completed task "+ DailyTask.WORK.toString());
			task = DailyTask.WORK;
		}

		return this;
	}
	public WeeklySchedule goToSchool(){
		if(task != DailyTask.WORK){
			System.out.println("The task is out of Order. The expected task is "+ DailyTask.WORK.toString());
		}
		else{
			System.out.println( "Completed task "+ DailyTask.SCHOOL.toString());
			task = DailyTask.SCHOOL;
		}

		return this;
	}

	public WeeklySchedule goToSleep(){
		if(task != DailyTask.SCHOOL){
			System.out.println("The task is out of Order. The expected task is "+ DailyTask.SCHOOL.toString());
		}
		else{
			System.out.println( "Completed task "+ DailyTask.END.toString());
			task = DailyTask.END;
		}
		return this;
	}

}
