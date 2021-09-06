package com.purplefrizzel.weather.api.resources.time;

import com.purplefrizzel.weather.api.models.ApiResponse;
import com.purplefrizzel.weather.api.models.time.Time;
import com.purplefrizzel.weather.core.resources.ResourceFactory;
import com.purplefrizzel.weather.services.time.TimeService;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.NotEmpty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;

@Path("/api/time/")
@Produces(MediaType.APPLICATION_JSON)
public class TimeResource {

    private final TimeService timeService;

    public TimeResource(TimeService timeService) {
        this.timeService = timeService;
    }

    @GET
    @Operation(
            summary = "This endpoint returns the current time and date for a given timezone.",
            description = "This endpoint returns the current time and date for a given timezone. "
                    + "This can be used to show the current time in a location based on the timezone returned in a weather forecast response.",
            tags = {"Time"}
    )
    public ApiResponse<Time> getTime(@QueryParam("timeZone") @NotEmpty String timeZone) throws URISyntaxException, IOException, InterruptedException {
        return new ApiResponse<>(timeService.getTime(timeZone), new ApiResponse.Metadata());
    }

    public static class Factory implements ResourceFactory<TimeResource> {

        @Override
        public TimeResource create() {
            return new TimeResource(new TimeService());
        }
    }
}
