%Anthony D'Alessandro
%Plotter function that takes a file name, a minimum value for the range of
%x, a maximum value for the range of x, and an increment value as
%parameters
function Plotter(fileName, min, max, increment)

    %Define the polynomial function as x^2 + 2x + 1
    p = [1 2 1];

    %Assign the vector x values from min to max using the increment value
    %to increment min up to max
    x = min:increment:max;

    %Assign the vector y the values resulting from plugging in each x value
    %into the polynomial function
    y = polyval(p,x);

    %Give a name to the plotting figure
    PlottingFigure = figure('Name', 'Plotter');

    %Plot the function using the vector x as x-axis values and the vector y
    %as y-axis values
    plot(x, y)
    %Give a title to the plot
    title("Population Size of " + max + " With an Increment of " + increment)

    %Concatenate the vector of x values with the vector of y values to make one
    %matrix
    xy = [x;y];

    %Transpose the matrix so the x values are in column 1 and the y values
    %are in column 2
    xy = xy';
    
    %Write the x and y values to a CSV file
    writematrix(xy, fileName)
end
