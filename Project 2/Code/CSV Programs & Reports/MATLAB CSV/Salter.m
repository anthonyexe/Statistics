function Salter(fileName, saltMin, saltMax)

    values = readmatrix(fileName);
    
    x = values(:,1);
    y = values(:,2);

    for i = 1:length(y)
        saltValue = (saltMax - saltMin).*rand(1) + saltMin;
        randomNumber = int32(randi([0, 1]));
        if randomNumber == 0
            y(i) = y(i) + saltValue;
        else
            y(i) = y(i) - saltValue;
        end
    end
    
    SalterFigure = figure('name', 'Salter');
    plot(x, y)
    title("Salted Data With a Salt Range of [" + saltMin + ", " + saltMax + "]")
    
    xy = [x(:), y(:)];
    disp(xy)
    writematrix(xy, 'saltedxyValues.csv')
end