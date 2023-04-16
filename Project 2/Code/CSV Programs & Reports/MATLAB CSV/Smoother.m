function Smoother(fileName, windowValue)
    values = readmatrix(fileName);

    x = values(:,1);
    y = values(:,2);

    smoothedValues = movmean(y, windowValue);

    SmootherFigure = figure('name', 'Smoother');
    plot(x, smoothedValues)
    title("Smoothed Data With a Window Size of " + windowValue)

    xy = [x(:), smoothedValues(:)];
    writematrix(xy, 'smoothedValues3.csv')
end