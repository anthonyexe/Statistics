%Anthony D'Alessandro
%Smoother function the takes a file name and a window value for the
%smoothing window as parameters
function Smoother(fileName, windowValue)

    %Read from a CSV file and store the values in a matrix
    values = readmatrix(fileName);

    %Split the values matrix into two separate vectors of x values and y
    %values
    x = values(:,1);
    y = values(:,2);

    %Create a vector to store the 'moving mean' values from the vector of y
    %values
    smoothedValues = movmean(y, windowValue);

    %Give a name to the plotting figure
    SmootherFigure = figure('name', 'Smoother');

    %Plot the data using the vector x as x-axis values and the smoothed
    %y values as y-axis values
    plot(x, smoothedValues)
    %Give a title to the plot
    title("Smoothed Data With a Window Size of " + windowValue)

    %Concatenate the vector of x values with the vector of smoothed y 
    % values so that the x values are in column 1 and the smoothed y 
    % values are in column 2
    xy = [x(:), smoothedValues(:)];

    %Write the x and smoothed y values to a CSV file
    writematrix(xy, 'smoothedValues3.csv')
end
