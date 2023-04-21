%Anthony D'Alessandro
%Salter function that takes a file name, a minimum salt value for the range
%of the salting value, and a maximum salt value for the range of the
%salting value as parameters
function Salter(fileName, saltMin, saltMax)

    %Read from a CSV file and store the values in a matrix
    values = readmatrix(fileName);
    
    %Split the values matrix into two separate vectors of x values and y
    %values
    x = values(:,1);
    y = values(:,2);

    %Loop through the y values and randomly add or subtract the random salt
    %value to/from each y value
    for i = 1:length(y)
        %Generate a random salt value within the salt range
        saltValue = (saltMax - saltMin).*rand(1) + saltMin;

        %Generate a random integer of either 0 or 1
        randomNumber = int32(randi([0, 1]));

        %In the case that the random integer is 0, add the salt value to
        %the y value and reassign to the corresponding position in the
        %vector
        if randomNumber == 0
            y(i) = y(i) + saltValue;
        
        %In the case that the random integer is 1, subtract the salt value
        %from the y value and reassign to the corresponding position in the
        %vector
        else
            y(i) = y(i) - saltValue;
        end
    end
    
    %Give a name to the plotting figure
    SalterFigure = figure('name', 'Salter');

    %Plot the data using the vector x as x-axis values and the vector y
    %as y-axis values
    plot(x, y)
    %Give a title to the plot
    title("Salted Data With a Salt Range of [" + saltMin + ", " + saltMax + "]")
    
    %Concatenate the vector of x values with the vector of salted y values
    % so that the x values are in column 1 and the salted y values are in 
    % column 2
    xy = [x(:), y(:)];

    %Write the x and y values to a CSV file
    writematrix(xy, 'saltedxyValues.csv')
end
