package com.example.qrdz4162.cvit.movies.presenter;

import com.example.qrdz4162.cvit.home.model.NasiListRepo;
import com.example.qrdz4162.cvit.home.model.entitiy.UpComingEventsResponse;
import com.example.qrdz4162.cvit.home.presenter.HomePresenter;
import com.example.qrdz4162.cvit.home.presenter.HomePresenterImp;
import com.example.qrdz4162.cvit.home.view.MovieView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import io.reactivex.schedulers.TestScheduler;

/**
 * Created by qrdz4162 on 2/10/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class HomePresenterTest {

    @Mock
    MovieView movieViewTest; //mocking the view layer

    @Mock
    NasiListRepo nasiListRepoTest; //mocking the model layer

    @Mock
    List<UpComingEventsResponse> upComingEventsResponses;

    TestScheduler testScheduler;

    private HomePresenter homePresenterTest;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        // Mock scheduler using RxJava TestScheduler
        testScheduler = new TestScheduler();

        homePresenterTest = new HomePresenterImp(movieViewTest, nasiListRepoTest,testScheduler , testScheduler);
    }

    @Test
    public void testLoadMovies(){
        String searchInputTest = "Batman";

//        when(nasiListRepoTest.getMovies(searchInputTest)).thenReturn(Observable.just(upComingEventsResponses));
//        homePresenterTest.loadMovies(searchInputTest);
//        testScheduler.triggerActions();

// verify(movieViewTest).hideProgressLoading();
// verify(movieViewTest).showProgressLoading();
    }

}
