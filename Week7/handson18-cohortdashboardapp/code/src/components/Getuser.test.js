import React from 'react';
import { render, screen, waitFor } from '@testing-library/react';
import Getuser from './Getuser';

global.fetch = jest.fn(() =>
  Promise.resolve({
    json: () => Promise.resolve({
      results: [
        {
          name: { title: 'Mr', first: 'John' },
          picture: { medium: 'https://via.placeholder.com/150' }
        }
      ]
    })
  })
);

describe('Getuser Component', () => {
  test('renders user details from API', async () => {
    render(<Getuser />);

    expect(screen.getByText(/loading/i)).toBeInTheDocument();

    await waitFor(() => {
      expect(screen.getByText(/Name: Mr John/i)).toBeInTheDocument();
      expect(screen.getByAltText(/user/i)).toBeInTheDocument();
    });
  });
});
