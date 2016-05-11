package com.hat.googleplay;

import javax.annotation.PreDestroy;

public interface AppRankInterface {

	void getRank(String packageName, String categoryName, boolean isFree);
}
